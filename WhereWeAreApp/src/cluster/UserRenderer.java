package cluster;

import android.R;
import android.content.Context;
import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

public class UserRenderer extends DefaultClusterRenderer<UserItem>{

    public UserRenderer(Context context, GoogleMap map,
            ClusterManager<UserItem> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onBeforeClusterItemRendered(UserItem item, MarkerOptions markerOptions) {
        super.onBeforeClusterItemRendered(item, markerOptions);

        markerOptions.title(item.getName());
        
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        //BitmapDescriptorFactory.defaultMarker(hue);
        //markerOptions.icon(BitmapDescriptorFactory
               // .fromResource(R.drawable.ic_dialog_alert));
       
        //c.colorToHSV(
    }

    @Override
    protected void onClusterItemRendered(UserItem clusterItem, Marker marker) {
        super.onClusterItemRendered(clusterItem, marker);

        //here you have access to the marker itself
    }
}