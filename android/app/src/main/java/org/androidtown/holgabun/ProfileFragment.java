package org.androidtown.holgabun;


        import android.app.Activity;
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.net.Uri;
        import android.nfc.Tag;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.renderscript.ScriptGroup;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AlertDialog;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;
        import java.io.InputStream;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView listView;
    FeedAdapter feedAdapter;
    String feed_id;

    String url;
    ProgressDialog loading;
    TextView t;

    ImageView img;
    Button b;
    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        Button writeButton = (Button) view.findViewById(R.id.write);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WriteActivity.class);
                startActivity(intent);
            }
        });

        b=(Button)view.findViewById(R.id.logout);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("주의");
                builder.setMessage("로그아웃을 하시면 SNS을 이용하실 수 없어 홈으로 돌아갑니다.");
                builder.setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                DbOpenHelper h=new DbOpenHelper(getContext());
                                h.open();
                                h.logOut();
                                Intent intent= new Intent(getContext(),MainActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        });
                builder.setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
            }
        });


        listView=(ListView)view.findViewById(R.id.myfeed);

        t=(TextView)view.findViewById(R.id.nickname_profile);




        DbOpenHelper h=new DbOpenHelper(getActivity());

        h.open();

        t.setText(h.returnId());

        feed_id=h.returnId();

        List();

        return view;
    }

    private void List(){
        class ListSaw extends AsyncTask<String,Void,String> {


            RequestHandler rh = new RequestHandler();
            FeedAdapter feedAdapter=new FeedAdapter();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(getContext(), "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (loading != null && loading.isShowing()) {
                    loading.dismiss();
                    loading = null;
                }
                Log.d("THIS", s);

                listView.setAdapter(feedAdapter);
            }

            @Override
            protected String doInBackground(String... params) {



                HashMap<String,String> data = new HashMap<>();


                data.put("ID",feed_id);

                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/MyBolder.php",data);


                try {
                    JSONArray j = new JSONArray(result);


                    for (int i = 0; i < j.length(); i++) {

                        feedAdapter=new FeedAdapter();
                        // Array 에서 하나의 JSONObject 를 추출
                        JSONObject dataJsonObject = j.getJSONObject(i);
                        // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시

                        URL url=new URL(dataJsonObject.getString("image").replace("\\",""));

                        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                        conn.setDoInput(true);
                        conn.connect();
                        InputStream is=conn.getInputStream();

                        feedAdapter.addItem(dataJsonObject.getString("id"),BitmapFactory.decodeStream(is),dataJsonObject.getString("text"),
                                dataJsonObject.getString("bolderNum"),dataJsonObject.getString("time"));


                    }




                }catch(JSONException e)
                {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }
        }

        ListSaw ui = new ListSaw();
        ui.execute("");
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (loading != null) {
            loading.dismiss();
            loading = null;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and na
        void onFragmentInteraction(Uri uri);
    }


//    public void onButtonWrite(View v){ //write 페이지로 이동
//        Intent intent = new Intent(getActivity(), MainActivity.class);
//        startActivity(intent);
//    }
}
