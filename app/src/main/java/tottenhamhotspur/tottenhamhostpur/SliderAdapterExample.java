package tottenhamhotspur.tottenhamhostpur;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }
    //region (0~8) 9가지 이미지를 넣어주는 작업
    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        viewHolder.textViewDescription.setText("This is New Tottenham Stadium ");

        switch (position) {
            case 0:
                Glide.with(context)//viewHolder.itemview 를 >> context
                        .load(R.drawable.stadium_main4)
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                Glide.with(context)
                        .load(R.drawable.stadium_one)
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                Glide.with(context)
                        .load(R.drawable.stadium_two)
                        .into(viewHolder.imageViewBackground);
                break;
            case 3:
                Glide.with(context)
                        .load(R.drawable.stadium_three)
                        .into(viewHolder.imageViewBackground);
                break;
            case 4:
                Glide.with(context)
                        .load(R.drawable.stadium_four)
                        .into(viewHolder.imageViewBackground);
                break;
            case 5:
                Glide.with(context)
                        .load(R.drawable.stadium_five)
                        .into(viewHolder.imageViewBackground);
                break;
            case 6:
                Glide.with(context)
                        .load(R.drawable.stadium_six)
                        .into(viewHolder.imageViewBackground);
                break;
            case 7:
                Glide.with(context)
                        .load(R.drawable.stadium_seven)
                        .into(viewHolder.imageViewBackground);
                break;
            case 8:
                Glide.with(context)
                        .load(R.drawable.stadium_eight)
                        .into(viewHolder.imageViewBackground);
                break;

        }

    }//endregion

    //region getCount 메소드에 9를 리턴해줌
    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 9;
    }//endregion

    //region SliderAdapterVH클래스 생성
    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }
    //endregion
}
