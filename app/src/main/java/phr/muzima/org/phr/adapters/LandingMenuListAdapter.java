package phr.muzima.org.phr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import phr.muzima.org.phr.R;
import phr.muzima.org.phr.model.LandingMenuItem;

/**
 * Created by HP on 1/12/2018.
 */

public class LandingMenuListAdapter extends BaseAdapter{
    List<LandingMenuItem> landingMenuItemsList;
    Context context;

    public LandingMenuListAdapter(Context context, List<LandingMenuItem> landingMenuItemList) {
        this.landingMenuItemsList = landingMenuItemList;
        this.context = context;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return landingMenuItemsList.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return landingMenuItemsList.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LandingMenuListAdapter.ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.landing_page_listview_single_row, parent, false);
            viewHolder = new LandingMenuListAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (LandingMenuListAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.landingMenuItemTitleTextView.setText(landingMenuItemsList.get(position).getTitle());
        viewHolder.landingMenuItemImageView.setImageResource(landingMenuItemsList.get(position).getIconResourceId());

        return convertView;
    }

    public class ViewHolder {

        TextView landingMenuItemTitleTextView;
        ImageView landingMenuItemImageView;

        ViewHolder(View view) {
            landingMenuItemTitleTextView = view.findViewById(R.id.notifications_title_textView);
            landingMenuItemImageView = view.findViewById(R.id.landing_page_imageView);
        }

    }
}

