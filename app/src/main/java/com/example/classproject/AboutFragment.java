package com.example.classproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class AboutFragment extends AppCompatActivity {
    ListView listView;
    String[] title = {"About us", "YouTube", "Twitter", "Instagram", "WhatsApp"};
    String[] description = {"The Greater lover Church is located at Rongai, Eldoret and Machakos", "Follow us on Youtube to the our latest sermons and services live",
            "Also follow as on twitter @tglchurch", "We also have instagram account", "get in touch via Whatsapp"};
    int[] image = {R.drawable.supernatural, R.drawable.youtube, R.drawable.twitter, R.drawable.instagram, R.drawable.whatsaap};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.fragment_about);

        listView = findViewById(R.id.aboutlistView);

        myAdapter adapter = new myAdapter(this, title, description, image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(AboutFragment.this, "Opening about us", Toast.LENGTH_LONG).show();
                }
                if (position == 1) {
                    Toast.makeText(AboutFragment.this, "Opening about youtube", Toast.LENGTH_LONG).show();
                }
                if (position == 2) {
                    Toast.makeText(AboutFragment.this, "Opening about twitter", Toast.LENGTH_LONG).show();
                }
                if (position == 3) {
                    Toast.makeText(AboutFragment.this, "Opening about Instagram", Toast.LENGTH_LONG).show();
                }
                if (position == 4) {
                    Toast.makeText(AboutFragment.this, "Opening about Whatsapp", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    class myAdapter extends ArrayAdapter {
        Context context;
        String[] rTitle;
        String[] rDescription;
        int[] rImage;

        myAdapter(Context c, String[] rTitle, String[] rDescription, int[] rImage) {
            super(c, R.layout.socialmedia, R.id.title1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImage = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.socialmedia, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.title1);
            TextView myDescription = row.findViewById(R.id.description1);

            images.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }

    public class HomeFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_about, container, false);
        }

    }
}