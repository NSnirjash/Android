package com.nsnirjash.androidappjee59.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nsnirjash.androidappjee59.R;
import com.nsnirjash.androidappjee59.model.PurbachalModel;
import com.nsnirjash.androidappjee59.model.RangdhanuModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RangdhanuAdapter extends RecyclerView.Adapter<RangdhanuAdapter.viewHolder> {

    private List<RangdhanuModel> RangdhanuModelList;
    private Context context;

    public RangdhanuAdapter(List<RangdhanuModel> rangdhanuModelList, Context context) {
        RangdhanuModelList = rangdhanuModelList;
        this.context = context;
    }


    @NonNull
    @Override
    public RangdhanuAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.member_details, parent, false);

        return new RangdhanuAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RangdhanuAdapter.viewHolder holder, int position) {

        RangdhanuModel member = RangdhanuModelList.get(position);
        holder.bind(member);

    }

    @Override
    public int getItemCount() {
        return RangdhanuModelList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView clubPosition;
        TextView address1;
        TextView address2;
        TextView cell;
        TextView email;
        TextView membershipNo;
        TextView bloodGroup;
        ImageView memberImage;
        ImageView btnCall;
        ImageView btnEmail;
        ImageView btnSms;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            clubPosition = itemView.findViewById(R.id.clubPosition);
            address1 = itemView.findViewById(R.id.address1);
            address2 = itemView.findViewById(R.id.address2);
            cell = itemView.findViewById(R.id.cell);
            email = itemView.findViewById(R.id.email);
            membershipNo = itemView.findViewById(R.id.membershipNo);
            bloodGroup = itemView.findViewById(R.id.bloodGroup);
            memberImage = itemView.findViewById(R.id.memberImage);
            btnCall = itemView.findViewById(R.id.btnCall);
            btnEmail = itemView.findViewById(R.id.btnEmail);
            btnSms = itemView.findViewById(R.id.btnSms);
        }


        public void bind(RangdhanuModel member) {
            name.setText("Name: "+member.getName());
            clubPosition.setText("Club Position: "+member.getClubPosition());
            address1.setText("Address 1: "+member.getAddress1());
            address2.setText("Address 2: "+member.getAddress2());
            cell.setText("Cell: "+member.getCell());
            email.setText("Email: "+member.getEmail());
            membershipNo.setText("Membership No: "+member.getMembershipNo());
            bloodGroup.setText("Blood Group:  "+member.getBloodGroup());


            String relativeImagePathmember = member.getMemberImage();
            String baseUrlmember = "https://purbachal.emranhss.com/";
            String imageUrlmember = baseUrlmember + relativeImagePathmember;




            Picasso.get().load(imageUrlmember).into(memberImage);





            // Set up button click listeners
            btnCall.setOnClickListener(v -> {
                try {
                    makeCall(member.getCell());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            btnEmail.setOnClickListener(v -> {
                if (member != null) {
                    sendEmail(member.getEmail());
                }
            });

            btnSms.setOnClickListener(v -> {
                if (member != null) {
                    makeSMS(member.getCell());
                }
            });
        }

        private void makeCall(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            itemView.getContext().startActivity(intent);
        }
        private void makeSMS(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" +phoneNumber ));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            itemView.getContext().startActivity(intent);
        }

        private void sendEmail(String emailAddress) {
            // Implement logic to send an email
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + emailAddress));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            itemView.getContext().startActivity(intent);
        }
    }
}
