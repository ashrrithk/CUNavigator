package in.christuniversity.cunavigator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProgammingAdapter extends RecyclerView.Adapter<ProgammingAdapter.ProgrammingViewHolder> {
    private ArrayList<StudentMeet> data;
    private Context context;
    public ProgammingAdapter(ArrayList<StudentMeet> data,Context x) {
        this.data=data;
        this.context = x;
    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.student_list,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        StudentMeet student = data.get(position);
        holder.Name.setText(student.Name);
        holder.Class.setText(student.Class);
        holder.Timing.setText(student.Timing);
//        holder.txttitle.setText(title);
//        Glide.with(holder.imgIcon.getContext()).load("https://images-na.ssl-images-amazon.com/images/I/31PnwWfJ2fL._SX342_QL70_ML2_.jpg").into(holder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder{
        //        ImageView imgIcon;
        TextView Name;
        TextView Class;
        TextView Timing;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.studentNameA_tv);
            Class = itemView.findViewById(R.id.studentDegreeA_tv);
            Timing = itemView.findViewById(R.id.studentTimingA_tv);

        }
    }
}
