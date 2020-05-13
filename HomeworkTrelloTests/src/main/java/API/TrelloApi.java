package API;

import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {

    @POST("/1/boards")
    Call<Board> createBoard(@Body Board board, @Query("name") String name);
    @PUT("/1/boards/{id}")
    Call<Board> updateBoard(@Body Board board, @Path("id") String id);
    @DELETE("/1/boards/{id}")
    Call<Board> deleteBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);
    @POST("/1/lists")
    Call<List> createList(@Body List list, @Query("name") String name, @Query("idBoard") String idBoard);
    @POST("/1/cards")
    Call<Card> createCard(@Body Card card, @Query("idList") String idList, @Query("name") String name);
    @GET("/1/cards/{id}")
    Call<Card> getCard(@Path("id") String id, @Query("key") String key, @Query("token") String token);
    @PUT("/1/cards/{id}")
    Call<Card> updateCard(@Body Card card, @Path("id") String id, @Query("name") String name);
    @DELETE("/1/cards/{id}")
    Call<Card> deleteCard(@Path("id") String id, @Query("key") String key, @Query("token") String token);


    @POST("/1/boards/{id}/labels")
    Call<Label> createLabel(@Body Label label, @Path("id") String id, @Query("name") String name, @Query("color") String color);
    @PUT("/1/lists/{id}/idBoard")
    Call<List> moveList(@Body List list, @Path("id") String id, @Query("value") String value);
    @PUT("/1/cards/{id}")
    Call<Card> moveCardToList(@Body Card card, @Path("id") String id, @Query("idList") String idList);
    @PUT("/1/cards/{id}")
    Call<Card> moveCardInList(@Body Card card, @Path("id") String id, @Query("pos") int pos);
}
