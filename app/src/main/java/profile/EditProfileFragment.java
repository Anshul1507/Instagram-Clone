package profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import practice.module.com.instagram.R;
import utils.UniversalImageLoader;

public class EditProfileFragment extends Fragment {

    private ImageView mProfilePhoto;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile,container,false);
        mProfilePhoto = view.findViewById(R.id.profile_photo);

        setProfileImage();

        //back arrow for navigating back to "Profile Activity"
        ImageView backArrow = view.findViewById(R.id.backArrow_EditProfile);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        return view;
    }


    private void setProfileImage(){
        String imgURL = "crackberry.com/sites/crackberry.com/files/topic_images/2013/ANDROID.png";
        UniversalImageLoader.setImage(imgURL,mProfilePhoto,null,"https://");

    }

}
