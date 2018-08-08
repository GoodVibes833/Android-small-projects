package ca.hjtaki.dailygoals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CurrencyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Currency> currencyList;
    private CurrencyItemClickListener currencyItemClickListener;

    public CurrencyAdapter(Context context, List<Currency> currencyList, CurrencyItemClickListener currencyItemClickListener) {
        this.context = context;
        this.currencyList = currencyList;
        this.currencyItemClickListener = currencyItemClickListener;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return currencyList.size();
    }

    @Override
    public Object getItem(int position) {
        return currencyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currencyItemView = layoutInflater.inflate(R.layout.currency_item,null);
        TextView tvName = currencyItemView.findViewById(R.id.tvName);
        TextView tvRate = currencyItemView.findViewById(R.id.tvRate);

        final Currency c = currencyList.get(position);
        tvName.setText(c.getName());
        tvRate.setText(Double.toString(c.getRate()));

        currencyItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyItemClickListener.onCurrencyItemClick(c);

            }
        });

//4/4

        return currencyItemView;
    }
}
