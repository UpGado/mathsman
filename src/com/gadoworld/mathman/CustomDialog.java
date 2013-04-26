package com.gadoworld.mathman;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomDialog extends Dialog implements
		android.view.View.OnClickListener {

	public GraphActivity c;
	public Dialog d;
	public Button yes, no;

	public CustomDialog(GraphActivity a) {
		super(a);
		// TODO Auto-generated constructor stub
		this.c = a;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Enter Two Points");
		setContentView(R.layout.custom_dialog);
		yes = (Button) findViewById(R.id.btn_yes);
		no = (Button) findViewById(R.id.btn_no);
		yes.setOnClickListener(this);
		no.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_yes:
			EditText editX1 = (EditText) findViewById(R.id.editX1);
			EditText editY1 = (EditText) findViewById(R.id.editY1);
			EditText editX2 = (EditText) findViewById(R.id.editX2);
			EditText editY2 = (EditText) findViewById(R.id.editY2);
			if (!MainActivity.Empty(editX1) && !MainActivity.Empty(editY1) && !MainActivity.Empty(editX2) && !MainActivity.Empty(editY2) ) {
				double X1 = Double.parseDouble(editX1.getText().toString());
				double Y1 = Double.parseDouble(editY1.getText().toString());
				double X2 = Double.parseDouble(editX2.getText().toString());
				double Y2 = Double.parseDouble(editY2.getText().toString());
				if (X1 == X2 && Y1 == Y2) {
					Toast.makeText(c, "Enter Valid Points", Toast.LENGTH_SHORT).show();
				} else {
					c.add(X1, X2, Y1, Y2);
					this.dismiss();
				}
			break;}
		case R.id.btn_no:
			dismiss();
			break;
		default:
			break;
		}
		dismiss();
	}
}