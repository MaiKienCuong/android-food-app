package maikiencuong.android;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    private TextView textName, textDescription, textPrice, textQuantity;
    private ImageView viewImage;
    private ImageButton btnCong, btnTru;
    private Button btnAddtoCart;
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);
        getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        textName = findViewById(R.id.textName);
        textDescription = findViewById(R.id.textDescription);
        textPrice = findViewById(R.id.textPrice);
        textQuantity = findViewById(R.id.textQuantity);
        viewImage = findViewById(R.id.viewImage);
        viewImage = findViewById(R.id.viewImage);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnAddtoCart = findViewById(R.id.btnAddtoCart);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = textQuantity.getText().toString();
                try {
                    quantity = Integer.parseInt(s);
                    textQuantity.setText(++quantity + "");
                } catch (Exception e) {
                }
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = textQuantity.getText().toString();
                try {
                    quantity = Integer.parseInt(s);
                    if (quantity > 0)
                        textQuantity.setText(--quantity + "");
                } catch (Exception e) {
                }
            }
        });

        btnAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "Add to cart", Toast.LENGTH_SHORT).show();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Product product = (Product) bundle.getSerializable("product");
            textName.setText(product.getName());
            textDescription.setText(product.getDescription());
            textPrice.setText("$ " + product.getPrice());
            textQuantity.setText(quantity + "");
            viewImage.setImageResource(product.getImage());
            Log.i("products============", bundle.getSerializable("products").toString());
        }

    }
}