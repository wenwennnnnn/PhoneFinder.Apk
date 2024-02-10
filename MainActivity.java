package com.example.pptahta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewCategory();
        recyclerViewPopular();

        findViewById(R.id.brandBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BrandActivity.class));
            }
        });

        findViewById(R.id.storeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StoreActivity.class));
            }
        });
        findViewById(R.id.detailBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailsActivity.class));
            }
        });
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Memory", "cat_1"));
        category.add(new CategoryDomain("Camera", "cat_2"));
        category.add(new CategoryDomain("Battery", "cat_3"));
        category.add(new CategoryDomain("Feature", "cat_4"));
        category.add(new CategoryDomain("Gaming", "cat_5"));

        adapter=new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<PhoneDomain> phoneList=new ArrayList<>();
        phoneList.add(new PhoneDomain("Iphone 14 Pro","pop_1","Top Feature and good for job",29.0));
        phoneList.add(new PhoneDomain("Oppo Find X3 Pro","pop_2","Tampilan Mewah dan elegan",7.1));
        phoneList.add(new PhoneDomain("Realmi Narzo 30","pop_3","Batrai sangat awet dan cocok untuk bermain game",1.7));

        adapter2=new PopularAdaptor(phoneList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

}