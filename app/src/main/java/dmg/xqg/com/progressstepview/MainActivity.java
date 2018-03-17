package dmg.xqg.com.progressstepview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> mList = new ArrayList<>();
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");
        mList.add("a");

        ListView listView = (ListView) findViewById(R.id.listView);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mList.size();
            }

            @Override
            public Object getItem(int position) {
                return mList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    convertView = View.inflate(MainActivity.this,R.layout.item_view_process, null);
                    holder = new ViewHolder(convertView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }

                // 显示隐藏竖线
                if (position == 0){
                    holder.lineTop.setVisibility(View.INVISIBLE);
                    holder.tvLineBottom.setVisibility(View.VISIBLE);
                }else if (position == mList.size() -1){
                    holder.lineTop.setVisibility(View.VISIBLE);
                    holder.tvLineBottom.setVisibility(View.INVISIBLE);
                }else{
                    holder.lineTop.setVisibility(View.VISIBLE);
                    holder.tvLineBottom.setVisibility(View.VISIBLE);
                }

                return convertView;
            }
             class ViewHolder {
                 TextView tvContent;
                 TextView lineTop;
                 TextView tvLineBottom;
                 TextView tvTitle;

                ViewHolder(View convertView) {
                    tvContent = (TextView)convertView.findViewById(R.id.tvContent);
                    lineTop = (TextView)convertView.findViewById(R.id.lineTop);
                    tvLineBottom = (TextView)convertView.findViewById(R.id.tvLineBottom);
                    tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
                }
            }
        };
        listView.setAdapter(adapter);

    }
}
