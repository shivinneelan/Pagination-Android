package com.example.paginationrecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<ImageDetailsList> totallist = new ArrayList<>();
    ImageDetailsList dateBean;
    Adapter adapter;
    GridLayoutManager layoutManager;
    int page_num = 1;
    int min_page = 1, max_page = 4, per_page = 18;


    int visibleItemCount,totalItemCount,pastVisibleItemCount,previousTotal = 0;
    boolean isScrolling = true;
    int viewThreshold = 8;


    RecyclerView recyclerView;
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progress = (ProgressBar) findViewById(R.id.doc_progress_id);

        dateBean = new ImageDetailsList();
        setImageList();

        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);

        setAdapter();


    }

    private void setAdapter()
    {


        adapter = new Adapter(this,totallist);
        recyclerView.setAdapter(adapter);

         /*

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1) && newState==RecyclerView.SCROLL_STATE_IDLE) {
                    Log.d("-----","end");
                    if(page_num<max_page)
                    {
                        page_num++;
                        addImages();
                    }
                    else
                        Toast.makeText(MainActivity.this,"End... ",Toast.LENGTH_LONG).show();
                }
            }
        });

             */


       recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

           @Override
           public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
               super.onScrollStateChanged(recyclerView, newState);

               if (!recyclerView.canScrollVertically(1) && newState==RecyclerView.SCROLL_STATE_IDLE)
               {
                   progress.setVisibility(View.VISIBLE);
                   if (isScrolling)
                   {
                       if(page_num < max_page )
                       {
                           isScrolling = false;

                           page_num++;
                           Toast.makeText(MainActivity.this,"loading... "+ page_num,Toast.LENGTH_SHORT).show();
                           updateList(page_num);
                       }
                       else {
                           progress.setVisibility(View.GONE);

                           Toast.makeText(MainActivity.this, "End... ", Toast.LENGTH_SHORT).show();
                       }

                   }

               }
           }

           /*
           @Override
           public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
               super.onScrolled(recyclerView, dx, dy);

                    visibleItemCount = layoutManager.getChildCount();
                    totalItemCount = layoutManager.getItemCount();
                    pastVisibleItemCount = layoutManager.findFirstVisibleItemPosition();


                   if(isScrolling && (totalItemCount - visibleItemCount) <= (pastVisibleItemCount + viewThreshold))
                   {
                       if(page_num < max_page)
                       {

                           isScrolling = false;
                           page_num++;
                           Toast.makeText(MainActivity.this,"loading... "+ page_num,Toast.LENGTH_LONG).show();
                           updateList();
                       }
                       else
                           Toast.makeText(MainActivity.this,"End... ",Toast.LENGTH_LONG).show();

                   }
               }

            */

       });


    }

    public void updateList(int page_num)
    {
        List<ImageDetailsList> totallist = new ArrayList<>();
       ImageDetailsList dateBean = new ImageDetailsList();
        dateBean.setImage(R.drawable.download);
        dateBean.setImageName("Image "+page_num);
        totallist.add(dateBean);

        dateBean = new ImageDetailsList();
        dateBean.setImage(R.drawable.download1);
        dateBean.setImageName("Image "+page_num);
        totallist.add(dateBean);


        dateBean = new ImageDetailsList();
        dateBean.setImage(R.drawable.download2);
        dateBean.setImageName("Image "+page_num);
        totallist.add(dateBean);


        dateBean = new ImageDetailsList();
        dateBean.setImage(R.drawable.download3);
        dateBean.setImageName("Image "+page_num);
        totallist.add(dateBean);

        dateBean = new ImageDetailsList();
        dateBean.setImage(R.drawable.download4);
        dateBean.setImageName("Image "+page_num);
        totallist.add(dateBean);


        dateBean = new ImageDetailsList();
        dateBean.setImage(R.drawable.download5);
        dateBean.setImageName("Image "+page_num);
        totallist.add(dateBean);


        dateBean = new ImageDetailsList();
        dateBean.setImage(R.drawable.download6);
        dateBean.setImageName("Image "+page_num);
        totallist.add(dateBean);


        dateBean = new ImageDetailsList();
        dateBean.setImage(R.drawable.images);
        dateBean.setImageName("Image "+page_num);
        totallist.add(dateBean);


        addImages(totallist);
    }


    public void setImageList()
    {

        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images1);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images2);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images3);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images4);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images5);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images6);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images7);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images8);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images9);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


        dateBean = new ImageDetailsList();
dateBean.setImage(R.drawable.images10);
        dateBean.setImageName("Image");
                totallist.add(dateBean);


    }

    public void addImages(final List<ImageDetailsList> list)
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isScrolling = true;
                adapter.AddList(list);
                adapter.notifyDataSetChanged();
                progress.setVisibility(View.GONE);

            }
        },1000);


    }
}
