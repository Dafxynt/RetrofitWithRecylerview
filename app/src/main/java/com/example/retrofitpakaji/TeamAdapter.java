package com.example.retrofitpakaji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private List<Team> teams;
    private Context context;

    public TeamAdapter(List<Team> teams, Context context) {
        this.teams = teams;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.teamNameTextView.setText(team.getStrTeam());
        holder.stadiumTextView.setText(team.getStrStadium()); // Menampilkan nama stadion
        Glide.with(context).load(team.getStrTeamBadge()).into(holder.teamBadgeImageView);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamNameTextView;
        TextView stadiumTextView;
        ImageView teamBadgeImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamNameTextView = itemView.findViewById(R.id.teamNameTextView);
            stadiumTextView = itemView.findViewById(R.id.stadiumTextView); //
            teamBadgeImageView = itemView.findViewById(R.id.teamBadgeImageView);
        }
    }
}
