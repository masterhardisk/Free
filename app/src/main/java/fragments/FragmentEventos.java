package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.gerardo.free.R;

/**
 * Created by MasterHardisk on 8/06/16.
 */

public class FragmentEventos extends Fragment {
RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_eventos, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.recyclerview);
        return layout;
    }

}
