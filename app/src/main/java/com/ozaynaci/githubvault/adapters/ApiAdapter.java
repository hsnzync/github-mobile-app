package com.ozaynaci.githubvault.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ozaynaci.githubvault.R;
import com.ozaynaci.githubvault.models.ApiHandler;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ozaynaci on 23/05/2017.
 */

public class ApiAdapter extends ArrayAdapter<ApiHandler> {

    private Context context;
    private List<ApiHandler> values;

    public ApiAdapter(Context context, List<ApiHandler> values) {

        super(context, R.layout.item_list, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_list, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.item_results);
        TextView textView2 = (TextView) row.findViewById(R.id.item_results2);
        TextView textView3 = (TextView) row.findViewById(R.id.item_results3);
        TextView textView4 = (TextView) row.findViewById(R.id.item_results4);
        TextView textView5 = (TextView) row.findViewById(R.id.login_name);
        ImageView imageView = (ImageView) row.findViewById(R.id.profile_img);

        ApiHandler item = values.get(position);

        String message = item.getName();
        String message2 = item.getLanguage();
        String message3 = item.getCreated_at();
        String message4 = item.getDefault_branch();
        String message5 = item.getOwner().getLogin();
        String img = item.getOwner().getAvatar_url();

        textView.setText(message);
        textView2.setText(message2);
        textView3.setText(message3);
        textView4.setText(message4);
        textView5.setText(message5);

        Picasso.with(context)
                .load(img)
                .into(imageView);

        return row;
    }

}
