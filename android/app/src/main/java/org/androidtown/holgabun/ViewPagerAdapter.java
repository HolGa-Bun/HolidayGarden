
package org.androidtown.holgabun;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {

    ArrayList arrayList;
    LayoutInflater inflater;

    public ViewPagerAdapter(LayoutInflater inflater , ArrayList arrayList) {
        /*
         * 1번째인수 : View를 찾을떄스는 인수입니다.
         * 2번째인수 : Viewpager에 들어갈 Item(그림?)을 받아올 ArrayList 입니다.
         */
        this.inflater=inflater;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    //ViewPager가 현재 보여질 Item(View객체)를 생성할 필요가 있는 때 자동으로 호출
    /*
     * 1번째인수 : ViewPager 입니다.
     * 2번째인수 : 그화면당 해당 위치 처음부터 ( 0, 1, 2, 3 ...) 입니다.
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //새로운 View 객체를 Layoutinflater를 이용해서 생성
        View view= inflater.inflate(R.layout.activity_tutorial_view_pager_tutorial, null);

        // 메인에서찾는거와다르게 위에서 만들었던 View를 이용하여서 find 를 하는것을 주의하세요 :)
        ImageView img= (ImageView)view.findViewById(R.id.viewpager_image);

        //ImageView에 현재 position 번째에 해당하는 이미지를 보여주기 위한 작업
        int image = (int)arrayList.get(position);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        img.setImageResource(image);

        //ViewPager에 만들어 낸 View 추가
        container.addView(view);

        //Image가 세팅된 View를 리턴
        return view;
    }

    //화면에 보이지 않은 View는파쾨를 해서 메모리를 관리함.
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub

        //ViewPager에서 보이지 않는 View는 제거
        //세번째 파라미터가 View 객체 이지만 데이터 타입이 Object여서 형변환 실시
        container.removeView((View)object);

    }

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        // TODO Auto-generated method stub
        return v==((View)obj);
    }

}

