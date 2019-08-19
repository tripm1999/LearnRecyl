package com.phamminhtri.learnrecyl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterStudent extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<StudentModel> modelArrayList;
    public static int ITEM_STUDENT = 1;
    public static int ITEM_IMAGE = 2;
    public static int ITEM_LOAD = 3;


    public AdapterStudent(ArrayList<StudentModel> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getItemViewType(int position) {
        if ((position % 2) == 0 && position > 0) {
            return ITEM_IMAGE;
        } else if (position == modelArrayList.size()-1) {
            return ITEM_LOAD;
        } else {
            return ITEM_STUDENT;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_STUDENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item1, parent, false);
            return new ItemStudent(view);
        } else if(viewType == ITEM_LOAD) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemloadmore, parent, false);
            return new ItemImage(view);
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item2, parent, false);
            return new ItemImage(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemStudent) {
            StudentModel studentModel = modelArrayList.get(position);
            ((ItemStudent) holder).Container(studentModel.getName(), studentModel.getOld());
        } else if(holder instanceof  Loadmore) {
            ((Loadmore) holder).Container();
        }else {
            ((ItemImage) holder).Container();
        }


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


    public static class ItemStudent extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvOld;

        public ItemStudent(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvOld = (TextView) itemView.findViewById(R.id.tv_old);

        }

        public void Container(String name, String old) {
            tvName.setText(name);
            tvOld.setText(old);

        }
    }

    public static class ItemImage extends RecyclerView.ViewHolder {
        private ImageView img;

        public ItemImage(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_img);

        }

        public void Container() {
        }
    }

    public static class Loadmore extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;

        public Loadmore(@NonNull View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressbar);
        }
        public void Container() {
        }
    }
}


