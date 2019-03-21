package com.example.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class list extends AppCompatActivity {

    private static long back_pressed;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<item> items = new ArrayList<item>();
        for(int i = 1; i < 1000000; i++)
        {
            String digit = digit(i);
            items.add(new item(digit));
        }

        ItemAdapter itemAdapter = new ItemAdapter(items);

        recyclerView.setAdapter(itemAdapter);
    }

    public String digit(int num)
    {
        String digit = "";
        String[] arr_10 = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        String[] arr_20 = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
        String[] arr_20_90 = {"двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] arr_100 =  {"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        String[] arr_1000 = {"одна тысяча","две тысячи","три тысячи","четыре тысячи","пять тысяч","шесть тысяч","семь тысяч","восемь тысяч","девять тысяч"};
        String[] arr_10000_20000 = {"десять тысяч","одиннадцать тысяч","двенадцать тысяч","тринадцать тысяч","четырнадцать тысяч","пятнадцать тысяч","шестнадцать тысяч","семнадцать тысяч","восемнадцать тысяч","девятнадцать тысяч"};
        if (num <=9)
        {
            digit += arr_10[num];
        }
        if(num > 9 && num < 20)
        {
            digit += arr_20[num-10];
        }
        if(num > 19 && num < 100)
        {
            int prav = num%10;
            String sprav = arr_10[prav]+"";
            if(prav == 0)
            {
                sprav = "";
            }
            int a = num/10;
            int lev = a%10;
            digit += arr_20_90[lev-2] +" " + sprav;
        }
        if(num >= 100 && num < 1000)
        {
            int prav1 = num%10;
            int prav2 = (num/10)%10;
            int lev = (num/100)%10;
            String sprav = "";
            digit = arr_100[lev-1] + " ";
            if(prav2 == 0)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                sprav = arr_10[prav1];
                digit += sprav;
            }
            if(prav2 == 1)
            {
                sprav += arr_20[prav1];
                digit+=sprav;
            }
            if(prav2 > 1)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                else sprav = arr_10[prav1];
                digit += arr_20_90[prav2-2] +" " + sprav;
            }
        }
        if( num >=1000 && num < 10000 && num% 1000 == 0)
        {
            digit += arr_1000[num/1000-1];
        }
        else if ( num >1000 && num < 10000)
        {
            int prav1 = num%10;
            int prav2 = (num/10)%10;
            int lev2 = (num/100)%10;
            int lev1 = (num/1000)%10;
            String sprav = "";
            if(lev2 == 0)
            {
                digit = arr_1000[lev1-1] + " ";
            }
            else{
                digit = arr_1000[lev1-1] +" "+ arr_100[lev2-1] + " ";
            }
            if(prav2 == 0)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                sprav = arr_10[prav1];
                digit += sprav;
            }
            if(prav2 == 1)
            {
                sprav += arr_20[prav1];
                digit+=sprav;
            }
            if(prav2 > 1)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                else sprav = arr_10[prav1];
                digit += arr_20_90[prav2-2] +" " + sprav;
            }

        }
        if(num>= 10000 && num < 20000 && num%1000==0)
        {
            digit = arr_10000_20000[num/1000-10];
        }
        else if(num >= 10000 && num < 20000)
        {
            int prav1 = num%10;
            int prav2 = (num/10)%10;
            int lev2 = (num/100)%10;
            int lev1 = (num/1000)%10;
            int lev = (num/1000)-10;
            String sprav = "";
            digit += arr_10000_20000[lev] + " ";


            if(prav2 == 0)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                sprav = arr_10[prav1];
                digit += sprav;
            }
            if(prav2 == 1)
            {
                sprav += arr_20[prav1];
                digit+=sprav;
            }
            if(prav2 > 1)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                else sprav = arr_10[prav1];
                digit += arr_20_90[prav2-2] +" " + sprav;
            }

        }
        if(num>=20000 && num < 100000 && num%10000==0)
        {
            digit = arr_20_90[num/10000-2] + " тысяч";
        }
        else if(num>=20000 && num < 100000)
        {
            int prav1 = num%10;
            int prav2 = (num/10)%10;
            int lev2 = (num/100)%10;
            int lev1 = (num/1000)%10;
            int lev = (num/10000)%10;
            String sprav = "";
            digit += arr_20_90[lev-2] + " тысяч ";
            if(prav2 == 0)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                sprav = arr_10[prav1];
                digit += sprav;
            }
            if(prav2 == 1)
            {
                sprav += arr_20[prav1];
                digit+=sprav;
            }
            if(prav2 > 1)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                else sprav = arr_10[prav1];
                digit += arr_20_90[prav2-2] +" " + sprav;
            }

        }
        if(num >= 100000 && num < 1000000 && num % 100000==0)
        {
            digit += arr_100[num/100000-1] + " тысяч ";
        } else if(num >= 100000 && num < 1000000)
        {
            int prav1 = num%10;
            int prav2 = (num/10)%10;
            int lev2 = (num/100)%10;
            int lev1 = (num/1000)%10;
            int lev = (num/10000)%10;
            String sprav = "";
            digit += arr_100[num/100000-1] + " тысяч ";
            if(prav2 == 0)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                sprav = arr_10[prav1];
                digit += sprav;
            }
            if(prav2 == 1)
            {
                sprav += arr_20[prav1];
                digit+=sprav;
            }
            if(prav2 > 1)
            {
                if(prav1 == 0)
                {
                    sprav = "";
                }
                else sprav = arr_10[prav1];
                digit += arr_20_90[prav2-2] +" " + sprav;
            }

        }
        if(num == 1000000)
        {
            digit = "ОДИН МИЛЛИОН!!!!!!!!!!!!!!!!!!";
        }
        return digit;
    }
}
