package com.example.baitap08;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView rcIcon;
    private SearchView searchView;
    private IconAdapter iconAdapter;
    private ArrayList<IconModel> arrayList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        rcIcon = findViewById(R.id.rcIcon);

        arrayList1 = new ArrayList<>();
        arrayList1.add(new IconModel(R.drawable.ic_baseline_call_24, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.ic_baseline_call_24, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.ic_baseline_call_24, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.ic_baseline_call_24, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.ic_baseline_call_24, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.ic_baseline_call_24, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.ic_baseline_call_24, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.ic_baseline_call_24, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.ic_baseline_call_24, "dfgfhyh sxdff"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);

        iconAdapter = new IconAdapter(this, arrayList1);
        rcIcon.setAdapter(iconAdapter);



        setupSearchView();
    }

    private void setupSearchView() {
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });
    }

    private void filterListener(String text) {
        List<IconModel> filteredList = new ArrayList<>();
        for (IconModel iconModel : arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(iconModel);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            iconAdapter.setListenerList(filteredList);
        }
    }
}
