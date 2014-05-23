package adapters;

import java.util.List;

import service.engineering.whereweare.R;
import model.User;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAdapter extends ArrayAdapter<User>{

	private List<User> items;
	private int layoutResourceId;
	private Context context;
	ArticlerHolder holder;
	
	public UserAdapter(Context context, int layoutResourceId, List<User> items) {
		super(context, layoutResourceId, items);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//SETUP 
		View row = convertView;

		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		row = inflater.inflate(layoutResourceId, parent, false);
		
		//assign articleholde the propriate fields 
		holder = new ArticlerHolder();
		holder.user= items.get(position);
		holder.showdetails = (ImageView)row.findViewById(R.id.show_User);

		holder.showdetails.setTag(holder.user);
		holder.grp = (ImageView)row.findViewById(R.id.user_group);
		holder.grp.setTag(holder.user);
		holder.username = (TextView)row.findViewById(R.id.user_name);
		row.setTag(holder);
		//Show Item in List
		setupItem(holder);
		return row;
	}
	
	/**
	 *  Set the Textfields of the Holder with the data form the article
	 * @param holder which fields get which data. 
	 */
	private void setupItem(ArticlerHolder holder) {
		holder.username.setText(holder.user.getName());
		holder.grp.setBackgroundColor(Color.parseColor(holder.user.getGroup().getColor()));
	}

	/**
	 * stats the ITems a ArticleHolder has to have 
	 *
	 */
	public static class ArticlerHolder {
		
		User user;
		TextView username;
		ImageView grp;
		ImageView showdetails;
	}

}




