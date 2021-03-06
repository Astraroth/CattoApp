package com.example.cattoapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.cattoapp.model.OnItemClickListener;
import com.example.cattoapp.R;
import com.example.cattoapp.model.CatBreed;
import java.util.ArrayList;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    private List<CatBreed> values;
    private final OnItemClickListener listener;
    private List<CatBreed> exampleList;
    private List<CatBreed> exampleListFull;

    public RecyclerViewAdapter(List<CatBreed> myDataset, OnItemClickListener listener) { //constructor
        values = myDataset;
        this.listener = listener;
        exampleListFull = new ArrayList<>(values);
    }

    public void add(int position, CatBreed item) {
        values.add(position, item);
        notifyItemInserted(position);
    }
    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        public TextView txtName;
        public TextView txtName2;
        public RelativeLayout parent_layout;
        public View layout;
        public ImageView catimage;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtName = (TextView) v.findViewById(R.id.firstLine);
            txtName2 = (TextView) v.findViewById(R.id.secondLine);
            parent_layout = (RelativeLayout) v.findViewById(R.id.parent_layout);
            catimage = (ImageView) v.findViewById(R.id.catImage);
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final CatBreed selectedCat = values.get(position);
        final String name = selectedCat.getName();
        final String origin = selectedCat.getOrigin();

        holder.txtName.setText(name);
        holder.txtName2.setText(origin);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(selectedCat);
            }
        });
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CatBreed> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (CatBreed item : exampleListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            values.clear();
            values.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}


