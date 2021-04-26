package maikiencuong.android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnSearch;
    private EditText textSearch;
    private ArrayList<Product> products;
    private ContentFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnSearch = findViewById(R.id.btnSearch);
        textSearch = findViewById(R.id.textSearch);

        products = new ArrayList<>();
        products.add(new Product("Bánh Tasdy Donut 1", "Bánh Tasdy Donut 1 Thơm ngon", 10, R.drawable.nam1));
        products.add(new Product("Bánh Pink Donut 1", "Bánh Pink Donut 1 Thơm ngon", 20, R.drawable.nam1));
        products.add(new Product("Bánh Floating Donut 1", "Bánh Floating Donut 1 Thơm ngon", 30, R.drawable.nam1));
        products.add(new Product("Bánh Tasdy Donut 2", "Bánh Tasdy Donut 2 Thơm ngon", 40, R.drawable.nam1));
        products.add(new Product("Bánh Pink Donut 2", "Bánh Pink Donut 2 Thơm ngon", 50, R.drawable.nam1));
        products.add(new Product("Bánh Floating Donut 2", "Bánh Floating Donut 2 Thơm ngon", 60, R.drawable.nam1));

        fragment = (ContentFragment) ContentFragment.newInstance(products);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment).commit();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String filter = textSearch.getText().toString();
                if (!filter.isEmpty()) {
                    ArrayList<Product> list = (ArrayList<Product>) products.stream()
                            .filter(x -> x.getName().toLowerCase().contains(filter.toLowerCase()))
                            .collect(Collectors.toList());
                    RecyclerView recyclerView = fragment.getRecyclerView();
                    ProductAdapter adapter = (ProductAdapter) recyclerView.getAdapter();
                    adapter.setProducts(list);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}