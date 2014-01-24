package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Mensaje;

public class MensajeAdapter extends BaseAdapter {

	ArrayList<Mensaje> data;

	LayoutInflater inflater;

	public MensajeAdapter(Context context, ArrayList<Mensaje> data) {
		super();
		inflater = LayoutInflater.from(context);
		this.data = data;

	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return Long.parseLong(((Mensaje) getItem(position)).getMensajeid());
	}

	private static class ViewHolder {
		TextView tvSubject;
		TextView tvEmail;
		TextView tvDate;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.list_row_anuncio, null);
			viewHolder = new ViewHolder();
			viewHolder.tvSubject = (TextView) convertView
					.findViewById(R.id.tvSubject);
			viewHolder.tvEmail = (TextView) convertView
					.findViewById(R.id.tvEmail);
			viewHolder.tvDate = (TextView) convertView
					.findViewById(R.id.tvDate);
			convertView.setTag(viewHolder);
		} else {
			// Si el convertView no es null se recuperan los datos y
			// actualizamos los datos que se visualizan
			viewHolder = (ViewHolder) convertView.getTag();
		}

		// Obtención de datos
		String subject = data.get(position).getSubject();
		String email = data.get(position).getEmaildestino();
		String date = SimpleDateFormat.getInstance().format(
				data.get(position).getCreation_timestamp());

		// Representación de datos
		viewHolder.tvSubject.setText(subject);
		viewHolder.tvEmail.setText(email);
		viewHolder.tvDate.setText(date);
		return convertView;
	}

}
