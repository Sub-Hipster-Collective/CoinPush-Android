/*
 * Copyright 2017 Jeffrey Thomas Piercy
 *
 * This file is part of CoinPush-Android.
 *
 * CoinPush-Android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CoinPush-Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CoinPush-Android.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.subhipstercollective.coinpush;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class AdapterCurrency extends ArrayAdapter<Currency>
{
    private final ArrayList<Currency> currencies;
    private final LayoutInflater inflater;
    
    AdapterCurrency(final Context context, final ArrayList<Currency> currencies)
    {
        super(context, -1, currencies);
    
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.currencies = currencies;
    }
    
    @NonNull
    public View getView(final int position, final View convertView, @NonNull final ViewGroup parent)
    {
        View currencyView = convertView == null ? inflater.inflate(R.layout.currency, parent, false) : convertView;
        ImageView icon = (ImageView)currencyView.findViewById(R.id.icon_currency);
        TextView emoji = (TextView)currencyView.findViewById(R.id.text_emoji);
        TextView textCurrency = (TextView)currencyView.findViewById(R.id.text_currency);
        
        Currency currency = currencies.get(position);
        icon.setImageResource(currency.icon);
        emoji.setTextSize(TypedValue.COMPLEX_UNIT_PX, ActivityMain.emojiSize);
        emoji.setText(currency.emoji);
        textCurrency.setText(currency.toString(true));
        
        return currencyView;
    }
    
    public View getDropDownView(final int position, final View convertView, @NonNull final ViewGroup parent)
    {
        return getView(position, convertView, parent);
    }
}
