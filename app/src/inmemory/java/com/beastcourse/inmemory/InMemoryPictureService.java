package com.beastcourse.inmemory;

import com.beastcourse.entities.EventPicture;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.EventPhotoService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Andrey on 03.12.2016.
 */

public class InMemoryPictureService extends BaseInMemory {
    public InMemoryPictureService(BeastApplication application) {
        super(application);
    }


    @Subscribe
    public void getCommunnityPhotos(EventPhotoService.SearchCommunityPhotoRequest request){
        EventPhotoService.SearchCommunityPhotoResponse response = new EventPhotoService.SearchCommunityPhotoResponse();
        response.communityPhotos = new ArrayList<>();
        response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/\" + 1 + \"?id=identicon"));
        response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/\" + 1 + \"?id=identicon"));
        response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/\" + 1 + \"?id=identicon"));

    }

    @Subscribe
    public void getBrotherHoodPhotos(EventPhotoService.SearchBrotherHoodPhotoRequest request){
        EventPhotoService.SearchBrotherHoodResponse response = new EventPhotoService.SearchBrotherHoodResponse();
        response.brotherHoodPhotos = new ArrayList<>();
        response.brotherHoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/\" + 1 + \"?id=identicon"));
        response.brotherHoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/\" + 1 + \"?id=identicon"));
        response.brotherHoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/\" + 1 + \"?id=identicon"));
    }

    @Subscribe
    public void getSocialPhotos(EventPhotoService.SearchSocialPhotosRequest request){
        EventPhotoService.SearchSocialPhotosResponse response = new EventPhotoService.SearchSocialPhotosResponse();
        response.socialPhotos = new ArrayList<>();
        response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/\" + 1 + \"?id=identicon"));
        response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/\" + 1 + \"?id=identicon"));
        response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/\" + 1 + \"?id=identicon"));
    }
}
