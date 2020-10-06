package in.christuniversity.cunavigator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.ProgrammingViewHolder> {
    private ArrayList<TimeTableData> data;
    private Context context;
    public TimeTableAdapter(ArrayList<TimeTableData> data, Context x) {
        this.data=data;
        this.context = x;
    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ds_inflate,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        TimeTableData timetable = data.get(position);
        Log.i("Data",timetable.toString());
        holder.subject.setText(timetable.subject);
        holder.timing.setText(timetable.timing);
        holder.course_code.setText(timetable.course);
        holder.block_detail.setText(timetable.block);
        holder.period.setText(timetable.period);
//        holder.txttitle.setText(title);
//        Glide.with(holder.imgIcon.getContext()).load("https://images-na.ssl-images-amazon.com/images/I/31PnwWfJ2fL._SX342_QL70_ML2_.jpg").into(holder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder{
        //        ImageView imgIcon;
        TextView subject;
        TextView timing;
        TextView course_code;
        TextView block_detail;
        TextView period;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.ds_subjectName);
            timing = itemView.findViewById(R.id.ds_timing);
            course_code = itemView.findViewById(R.id.ds_subjectCode);
            block_detail = itemView.findViewById(R.id.ds_blockDetail);
            period = itemView.findViewById(R.id.ds_periodnum);

        }
    }
}
