package org.androidtown.holgabun;

import android.app.ProgressDialog;
import android.content.Context;
<<<<<<< HEAD
<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> d7162a6... 0719 jiyoon
=======

import android.content.Intent;

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
<<<<<<< HEAD
=======
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
>>>>>>> d7162a6... 0719 jiyoon
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LikeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LikeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LikeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView listview;
    SearchUserAdapter adapter;
    EditText editText;
    Button button;
<<<<<<< HEAD
    String s1,s2,s3;
<<<<<<< HEAD
    InputMethodManager imm;
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
    ProgressDialog loading;
    String s1,s2,s3;

    InputMethodManager imm;

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
    private OnFragmentInteractionListener mListener;

    public LikeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LikeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LikeFragment newInstance(String param1, String param2) {
        LikeFragment fragment = new LikeFragment();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_like, container, false);

        listview=(ListView)view.findViewById(R.id.user_list);
        adapter=new SearchUserAdapter();
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                user item = (user) parent.getItemAtPosition(position) ;


                Intent Serch_i=new Intent(getActivity(),another_profile.class);
                Serch_i.putExtra("name",item.getName());
                startActivity(Serch_i);

            }
        });

<<<<<<< HEAD
=======
>>>>>>> d7162a6... 0719 jiyoon
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

        button=(Button)view.findViewById(R.id.user_Search);
        editText=(EditText)view.findViewById(R.id.SU);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List();
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        });

        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);




<<<<<<< HEAD
=======
            }
        });

>>>>>>> d7162a6... 0719 jiyoon
        return view;
    }

=======
        return view;
    }



>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

<<<<<<< HEAD
=======
    @Override
    public void onStop() {
        super.onStop();
        if (loading != null) {
            loading.dismiss();
            loading = null;
        }
    }




>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
<<<<<<< HEAD
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private void List(){
        class ListSaw extends AsyncTask<String,Void,String> {

<<<<<<< HEAD
            ProgressDialog loading;
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
            RequestHandler rh = new RequestHandler();

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
                Log.d("THIS",s);


                try{


<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                    JSONObject j=new JSONObject(s);

                    listview.setAdapter(null);

                    adapter=new SearchUserAdapter();


                    if(j.getString("result").equals("true")) {


                        adapter.addItem(editText.getText().toString(), j.getString("count"), j.getString("recent"));

                    }
                    listview.setAdapter(adapter);
<<<<<<< HEAD
=======
                    JSONArray j=new JSONArray(s);

                    SearchUserAdapter feedAdapter=new SearchUserAdapter();


                   for(int i=0;i<j.length();i++)
                   {
                       JSONObject h=j.getJSONObject(i);
                       if(i==0)
                       {
                           s1=h.getString("Search_name");
                       }
                       else if(i==1)
                       {
                           s2=h.getString("count");
                       }
                       else{
                           s3=h.getString("recent");
                       }
                   }

                   feedAdapter.addItem(s1,s2,s3);
>>>>>>> d7162a6... 0719 jiyoon
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

                }catch(JSONException e){
                    e.printStackTrace();
                }


            }

            @Override
            protected String doInBackground(String... params) {



                HashMap<String,String> data = new HashMap<>();


                data.put("ID",editText.getText().toString());

                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/SearchUser.php",data);


                return result;
            }
        }

        ListSaw ui = new ListSaw();
        ui.execute("");
    }

<<<<<<< HEAD
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
}
