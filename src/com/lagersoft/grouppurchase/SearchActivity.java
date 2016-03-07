package com.lagersoft.grouppurchase;

import com.lagersoft.gp.base.BaseFragment;
import com.lagersoft.widges.SearchClearEditText;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SearchActivity extends Activity {
	private com.lagersoft.widges.SearchClearEditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
	}

}
