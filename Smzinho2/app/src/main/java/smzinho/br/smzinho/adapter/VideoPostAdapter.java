package smzinho.br.smzinho.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import smzinho.br.smzinho.R;
import smzinho.br.smzinho.models.YoutubeDataModel;

/**
 * Created by Marcos Vinícius on 11/01/2018.
 */

public class VideoPostAdapter extends RecyclerView.Adapter<VideoPostAdapter.YoutubePostHolder> {

    private ArrayList<YoutubeDataModel> dataSet;
    private Context mContext = null;

    public VideoPostAdapter(Context mContext, ArrayList<YoutubeDataModel> dataSet) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    @Override
    public YoutubePostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_post_layout,parent,false);
        YoutubePostHolder postHolder = new YoutubePostHolder(view);
        return postHolder;
    }

    @Override
    public void onBindViewHolder(final YoutubePostHolder holder,final int position) {

        if (dataSet.size() == 0) {
            return;
        }

        TextView textViewTitle = holder.textViewTitle;
        TextView textViewDes = holder.textViewDes;
        ImageView ImageThumb = holder.ImageThumb;

        final YoutubeDataModel object = dataSet.get(position);

        textViewTitle.setText(object.getTitle());
        textViewDes.setText(object.getDescription());

        //TODO: image will be downloaded from url
        Picasso.with(mContext).load(object.getThumbnail()).into(ImageThumb);

        holder.ImageThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + object.getId())));
            }
        });

    }




    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class YoutubePostHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDes;
        ImageView ImageThumb;
        Context mContext;

        public YoutubePostHolder(View itemView) {
            super(itemView);
            this.mContext= itemView.getContext();
            this.textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            this.textViewDes = (TextView) itemView.findViewById(R.id.textViewDes);
            this.ImageThumb = (ImageView) itemView.findViewById(R.id.ImageThumb);

        }
    }
}
