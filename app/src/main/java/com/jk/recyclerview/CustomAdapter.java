package com.jk.recyclerview;



 import android.content.Context;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.TextView;
 import android.widget.Toast;

 import androidx.annotation.NonNull;
 import androidx.recyclerview.widget.RecyclerView;
 import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

      ArrayList <String> personNames;
      Context context;

    public CustomAdapter(Context context,ArrayList<String> personNames) {
        this.personNames = personNames;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        //inflate the item layout
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        //set the view's size, margin's, padding's and layout parameters
        MyViewHolder vh = new MyViewHolder(v);//pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(personNames.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, personNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return personNames.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
       //init the item view's
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //get the reference of item view's
            name=itemView.findViewById(R.id.name);
        }
    }
}
