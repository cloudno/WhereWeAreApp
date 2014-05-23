package service.engineering.whereweare;

import java.util.ArrayList;
import java.util.List;

import adapters.UserAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import model.User;


public class UserOverview extends Activity{
	List<User> meineliste;
	
	UserAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.);

		//Setup der Elemente 
		meineliste = new ArrayList<User>();
		//Setup der Artikelliste
		setup();
		
		
		
	}
	
	public void setup() {
		
		adapter = new UserAdapter(this,R.layout.user_list_item,
				meineliste);
		ListView articleListview = (ListView) findViewById(R.id.UserList);
		articleListview.setAdapter(adapter);
		
			/*
			 * };
			 */
	}
	
	public void addArticle(User user) {
		adapter.add(user);
	}

	
}
