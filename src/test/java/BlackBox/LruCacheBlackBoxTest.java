package BlackBox;

import BlackBox.Setups.LruCacheSetup;
import Utils.LruCacheMethod;
import org.junit.Test;

public class LruCacheBlackBoxTest extends LruCacheSetup {

    @Test
    public void dummyTest(){
        //constructor size = 2
        int[] functionParameters = new int[]{2};
        lruCachePUT.run(LruCacheMethod.Constructor,
                functionParameters,
                null);

        //put key=1, value = 2
        int[] functionParameters2 = new int[]{1,2};
        lruCachePUT.run(LruCacheMethod.Put,
                functionParameters2,
                null);

        //get key = 1
        int[] functionParameters3 = new int[]{1};
        lruCachePUT.run(LruCacheMethod.Get,
                functionParameters3,
                2);
    }


    @Test()
    public void noInputTest(){
        //constructor size = 2
        int[] constructParameters = new int[]{1};
        lruCachePUT.run(LruCacheMethod.Constructor,
                constructParameters,
                null);

        //get key = 1
        int[] getParameters = new int[]{0};
        lruCachePUT.run(LruCacheMethod.Get,
                getParameters,
                -1);
    }

    @Test(expected = NullPointerException.class)
    public void noSizeTest(){
        //constructor size = 2
        int[] constructParameters = new int[]{0};
        lruCachePUT.run(LruCacheMethod.Constructor,
                constructParameters,
                null);

        //put key=1, value = 2
        int[] functionParameters2 = new int[]{1,2};
        lruCachePUT.run(LruCacheMethod.Put,
                functionParameters2,
                null);
        
        //get key = 1
        int[] getParameters = new int[]{0};
        lruCachePUT.run(LruCacheMethod.Get,
                getParameters,
                -1);
    }

    @Test()
    public void negativeSizeTest(){
        //constructor size = 2
        int[] constructParameters = new int[]{-1};
        lruCachePUT.run(LruCacheMethod.Constructor,
                constructParameters,
                null);

        //put key=1, value = 2
        int[] functionParameters2 = new int[]{1,2};
        lruCachePUT.run(LruCacheMethod.Put,
                functionParameters2,
                null);
        
        //get key = 1
        int[] getParameters = new int[]{1};
        lruCachePUT.run(LruCacheMethod.Get,
                getParameters,
                2);
    }

    @Test()
    public void negativeKeyTest(){
        //constructor size = 2
        int[] constructParameters = new int[]{2};
        lruCachePUT.run(LruCacheMethod.Constructor,
                constructParameters,
                null);

        //put key=1, value = 2
        int[] functionParameters2 = new int[]{-1,2};
        lruCachePUT.run(LruCacheMethod.Put,
                functionParameters2,
                null);
        
        //get key = 1
        int[] getParameters = new int[]{-1};
        lruCachePUT.run(LruCacheMethod.Get,
                getParameters,
                2);
    }

    @Test
    public void consistentOutputTest(){
        //constructor size = 2
        int[] functionParameters = new int[]{2};
        lruCachePUT.run(LruCacheMethod.Constructor,
                functionParameters,
                null);

        //put key=1, value = 2
        int[] putParameters2 = new int[]{0,3};
        lruCachePUT.run(LruCacheMethod.Put,
                putParameters2,
                null);

        //put key=1, value = 2
        int[] functionParameters2 = new int[]{1,2};
        lruCachePUT.run(LruCacheMethod.Put,
                functionParameters2,
                null);

        //get key = 1
        int[] functionParameters3 = new int[]{1};
        lruCachePUT.run(LruCacheMethod.Get,
                functionParameters3,
                2);

        //get key = 1
        int[] get2 = new int[]{0};
        lruCachePUT.run(LruCacheMethod.Get,
                get2,
                3);

        lruCachePUT.run(LruCacheMethod.Get,
                get2,
                3);

        lruCachePUT.run(LruCacheMethod.Get,
                functionParameters3,
                2);
    }

    @Test
    public void longInsertTest(){
        //constructor size = 2
        int[] functionParameters = new int[]{1};
        lruCachePUT.run(LruCacheMethod.Constructor,
                functionParameters,
                null);

        int length = 10000;
        for (int i = 0; i < length; i++) {
                int[] put = new int[]{i,1};
                lruCachePUT.run(LruCacheMethod.Put,
                        put,
                        null);
                int[] get = new int[]{i};
                lruCachePUT.run(LruCacheMethod.Get,
                        get,
                        1);
                int[] getPrev = new int[]{i-1};
                lruCachePUT.run(LruCacheMethod.Get,
                        getPrev,
                        -1);
        }
    }

    @Test
    public void minMaxTest(){
        int[][] parameters = new int[][] {
                {Integer.MAX_VALUE, 1},
                {1, Integer.MAX_VALUE},
                {Integer.MIN_VALUE, 2},
                {2, Integer.MIN_VALUE},
        };
        
        int[] functionParameters = new int[]{parameters.length};
        lruCachePUT.run(LruCacheMethod.Constructor,
                functionParameters,
                null);

        for (int[] parameter : parameters) {
        lruCachePUT.run(LruCacheMethod.Put,
                parameter,
                null);
        }

        for (int[] parameter : parameters) {
        lruCachePUT.run(LruCacheMethod.Get,
                new int[] {parameter[0]},
                parameter[1]);
        }
    }
}
