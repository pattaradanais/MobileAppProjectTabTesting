package kku.sukruam.pattaradanai.tabtest;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by patipan on 9/21/2016 AD.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    //bake bakes = new bake();
    bake bakes;
    ListAdapter(Context context, bake banks) {
        this.context = context;
        this.bakes =banks;
    }

    @Override
    public int getCount() {
        if (bakes == null)
            return 0;
        if (bakes.getBakes() == null)
            return 0;

        return bakes.getBakes().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        LayoutInflater mInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(R.layout.list_item, parent, false);
//        if(convertView != null){
//            view = convertView;
//        }else {
//            view = mInflater.inflate(R.layout.list_item, parent, false);
//        }

        TextView textView = (TextView) view.findViewById(R.id.title);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textDesc = (TextView) view.findViewById(R.id.desc);


        if (bakes != null && bakes.getBakes() != null){
            textView.setText(bakes.getBakes().get(position).getBakegrill());
            imageView.setImageResource(bakes.getBakes().get(position).getResId());
            textDesc.setText(bakes.getBakes().get(position).getDescription());
        }


//        if (convertView != null)
//            view = convertView;
        return view;


    }
}
