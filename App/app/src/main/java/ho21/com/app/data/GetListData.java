package ho21.com.app.data;

public class GetListData{
    int categoryId =1;
    int page =1;
    int showNum = 10;
    boolean isLoading = false;

    private static final int COUNT = 25;
    private static final int TOTALPAGE = 4;

    /**
     * 是否还有更多
     * @param page
     * @return
     */
    public static boolean hasMore(int page) {
        return page < TOTALPAGE;
    }





}