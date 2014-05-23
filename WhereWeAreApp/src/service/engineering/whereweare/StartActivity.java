package service.engineering.whereweare;

import java.util.List;

import rest.IUserService;
import rest.RemoteUserService;
import rest.UserList;
import model.Group;
import model.User;
import cluster.UserItem;
import cluster.UserRenderer;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.google.android.gms.maps.MapFragment;
public class StartActivity extends Activity {
	
	
    // Google Map
    private GoogleMap googleMap;
    private ClusterManager<UserItem> mClusterManager;
    private Button btn;
    //ClusterManager cluster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
			
        		
			}
		});
      setUpMapIfNeeded();
    }
    

 
    protected GoogleMap getMap() {
        setUpMapIfNeeded();
        return googleMap;
    }
    
    private void setUpMapIfNeeded() {
        if (googleMap != null) {
            return;
        }
        
        //SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager()
               // .findFragmentById(R.id.map);

        //googleMap = mapFrag.getMap();
       googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
           .getMap(); 
       // googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (googleMap != null) {
        	setUpClusterer();
        }
    }
    
    
    private void setUpClusterer() {
        // Declare a variable for the cluster manager.
        

        // Position the map.
        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.503186, -0.126446), 10));

        // Initialize the manager with the context and the map.
        // (Activity extends context, so we can pass 'this' in the constructor.)
        mClusterManager = new ClusterManager<UserItem>(this, getMap());
         mClusterManager.setRenderer(new UserRenderer(this, getMap(), mClusterManager));

        
        // Point the map's listeners at the listeners implemented by the cluster
        // manager.
        getMap().setOnCameraChangeListener(mClusterManager);
        getMap().setOnMarkerClickListener(mClusterManager);

        // Add cluster items (markers) to the cluster manager.
        
        PerformGetAllArticleTask performGetAllArticleTask = new PerformGetAllArticleTask();
		performGetAllArticleTask.execute();
		
        //addItems();
    }

    private void addItems(UserList allUsers) {

    	/*//im ADD items Aufruf der User
    	
        // Set some lat/lng coordinates to start with.
        double lat = 51.5145160;
        double lng = -0.1270060;

        // Add ten cluster items in close proximity, for purposes of this example.
        for (int i = 0; i < 10; i++) {
            double offset = i / 60d;
            lat = lat + offset;
            lng = lng + offset;
            */
    	
    	List<User> theusers = allUsers.getUsers();
    	
    	for(int i = 0; i < theusers.size(); i++)
    	{
    		UserItem userItem = new UserItem(theusers.get(i));
            //Group grp = new Group();
            //UserItem userItem = new UserItem(i,grp, "Testuser" + i,"pwd", lat, lng, "Linz", null);
            		
            //MyItem offsetItem = new MyItem(lat, lng);
            mClusterManager.addItem(userItem);
        }
    }
    private void showDialog(String title, String message) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setCancelable(true);
		alertDialog.setNeutralButton("OK",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		alertDialog.show();
	}
    
    @Override
    protected void onResume() {
        super.onResume();
       setUpMapIfNeeded();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
    
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_start, container, false);
            return rootView;
        }
    }
    */
    
    private class PerformGetAllArticleTask extends AsyncTask<Void, Void, Void> {
		
		UserList allUsers;

		public PerformGetAllArticleTask() {
			
		}

		/*@Override
		protected void onPreExecute() {
			BasketOverview.this.showProgressDialog("gettingArticle...");
		}
		*/
		
		@Override
		protected Void doInBackground(Void... params) {
			IUserService service = new RemoteUserService();
			allUsers = service.getallUsers();
			return null;
		}

		
		@Override
		protected void onPostExecute(Void response) {
			//BasketOverview.this.dismissProgressDialog();
			// TODO: check if exceptions?
			if (allUsers != null) {
				addItems(allUsers);
				//addArticle(article);
				
				//to was
			} else {
				showDialog("Article not found", "Please try again.");
			}
		}

	}

}

