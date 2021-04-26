package maikiencuong.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnSearch;
    private EditText textSearch;
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnSearch = findViewById(R.id.btnSearch);
        textSearch = findViewById(R.id.textSearch);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        products.add(new Product("Bánh Tasdy Donut 1", "Bánh Tasdy Donut 1 Thơm ngon", 10, R.drawable.nam1));
        products.add(new Product("Bánh Pink Donut 1", "Bánh Pink Donut 1 Thơm ngon", 20, R.drawable.nam1));
        products.add(new Product("Bánh Floating Donut 1", "Bánh Floating Donut 1 Thơm ngon", 30, R.drawable.nam1));
        products.add(new Product("Bánh Tasdy Donut 2", "Bánh Tasdy Donut 2 Thơm ngon", 40, R.drawable.nam1));
        products.add(new Product("Bánh Pink Donut 2", "Bánh Pink Donut 2 Thơm ngon", 50, R.drawable.nam1));
        products.add(new Product("Bánh Floating Donut 2", "Bánh Floating Donut 2 Thơm ngon", 60, R.drawable.nam1));

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter=textSearch.getText().toString();
                if (!filter.isEmpty()) {
                    ArrayList<Product> list = new ArrayList<>();
                    for (Product p : products) {
                        if (p.getName().contains(filter))
                            list.add(p);
                    }
                    ProductAdapter adapter = (ProductAdapter) recyclerView.getAdapter();
                    adapter.setProducts(list);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        ProductAdapter adapter = new ProductAdapter(MainActivity.this, products);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}