package com.arsalan.transporttracker;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

class busViewHolder extends ViewHolder {

    TextView pointName,driverName,location,date;
//    private View subitem;
//    private TextView genre;
//    private TextView year;

    public busViewHolder(View view) {
        super(view);


        pointName = (TextView) view.findViewById(R.id.PointName);
        driverName = (TextView) view.findViewById(R.id.driverName);
        location = (TextView) view.findViewById(R.id.location);
        date = (TextView) view.findViewById(R.id.currentDate);

    }

    public void bind(final busListModel Model) {

        boolean expanded = Model.isExpanded();

       // subitem.setVisibility(expanded ? View.VISIBLE : View.GONE);


        pointName.setText(Model.PointName);
        driverName.setText(Model.DriverName);
        location.setText(Model.Location);
        date.setText(Model.Date);

//        genre.setText("Genre: " + Model.PointName);
//        year.setText("Year: " + Model.DriverName);

    }
}
