package com.komoriwu.one.model.http;

import com.komoriwu.one.model.bean.AuthorDetailBean;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.model.bean.CommentBean;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.MovieDetailBean;
import com.komoriwu.one.model.bean.MoviePhotoBean;
import com.komoriwu.one.model.bean.MusicDetailBean;
import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.model.bean.QuestionDetailBean;
import com.komoriwu.one.model.bean.ReadDetailBean;
import com.komoriwu.one.model.bean.TagsDetailBean;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.model.http.reponse.MyHttpResponse;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public interface HttpHelper {
    Flowable<OneIdBean> fetchOneId();

    Flowable<MyHttpResponse<OneListBean>> getOneList(String id);

    Flowable<MyHttpResponse<ReadDetailBean>> getReadDetail(String itemId);

    Flowable<MyHttpResponse<CommentBean>> geReadCommentDetail(String itemId);

    Flowable<MyHttpResponse<MovieDetailBean>> getMovieDetail(String itemId);

    Flowable<MyHttpResponse<MusicDetailBean>> getMusicDetail(String itemId);

    Flowable<MyHttpResponse<MoviePhotoBean>> geMoviePhoto(String itemId);

    Flowable<MyHttpResponse<QuestionDetailBean>> geQuestionDetail(String itemId);

    Flowable<VideoBean> getAllVideo();

    Flowable<VideoBean> getAllVideo(String date, String num, String page);

    Flowable<FindBean> getFindData();

    Flowable<FindBean> getFindMoreData(String start);

    Flowable<FindBean> getRecommendData(String page);

    Flowable<FindBean> getDetailRecommendData(String id);

    Flowable<FindBean> getDailyData();

    Flowable<FindBean> getDailyMoreData(String date, String num);

    Flowable<FindBean> getCategoryData(int position);

    Flowable<FindBean> getCategoryMoreData(int position, String start, String num);

    Flowable<FindBean> getAllCategoriesData();

    Flowable<CategoryDetailBean> getCategoriesDetailIndexData(String id);

    Flowable<FindBean> getCDetailData(int position, String id);

    Flowable<FindBean> getCDetailMoreData(int position, String id, HashMap<String, String> stringHashMap);

    Flowable<DataBean> getVideoDetailData(String id);

    Flowable<List<String>> getQueriesHotData();

    Flowable<FindBean> getQueryData(String query);

    Flowable<FindBean> getMoreQueryData(String query, String start, String num);


    Flowable<TagsDetailBean> getTagDetailIndexData(String id);

    Flowable<FindBean> getTagDetailData(int position, String id);

    Flowable<FindBean> getTagDetailMoreData(int position, String id, HashMap<String, String> stringHashMap);

    Flowable<AuthorDetailBean> getAuthorDetailIndexData(String id);

    Flowable<FindBean> getAuthorDetailData(int position, String id);

    Flowable<FindBean> getAuthorDetailMoreData(int position, String id, HashMap<String, String> stringHashMap);

}
