public class CacheConfig {
    private boolean noCache;
    private boolean noStore;
    private int maxAge;
    private int sMaxAge;

    public CacheConfig(boolean noCache, boolean noStore, int maxAge, int sMaxAge) {
        this.noCache = noCache;
        this.noStore = noStore;
        this.maxAge = maxAge;
        this.sMaxAge = sMaxAge;
    }

   

    public boolean isNoCache() {
        return noCache;
    }

    public void setNoCache(boolean noCache) {
        this.noCache = noCache;
    }

    public boolean isNoStore() {
        return noStore;
    }

    public void setNoStore(boolean noStore) {
        this.noStore = noStore;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getsMaxAge() {
        return sMaxAge;
    }

    public void setsMaxAge(int sMaxAge) {
        this.sMaxAge = sMaxAge;
    }

   
    public void fetchData() {
       
        System.out.println("Cache Configurations:");
        System.out.println("no-cache: " + noCache);
        System.out.println("no-store: " + noStore);
        System.out.println("max-age: " + maxAge);
        System.out.println("s-max-age: " + sMaxAge);
       
    }

    public static void main(String[] args) {

        CacheConfig cacheConfig1 = new CacheConfig(true, false, 0, 0); // no-cache
        CacheConfig cacheConfig2 = new CacheConfig(false, true, 0, 0); // no-store
        CacheConfig cacheConfig3 = new CacheConfig(false, false, 3600, 0); // max-age
        CacheConfig cacheConfig4 = new CacheConfig(false, false, 0, 3600); // s-max-age

        
        System.out.println("Performance with no-cache:");
        cacheConfig1.fetchData();

        System.out.println("Performance with no-store:");
        cacheConfig2.fetchData();

        System.out.println("Performance with max-age:");
        cacheConfig3.fetchData();

        System.out.println("Performance with s-max-age:");
        cacheConfig4.fetchData();
    }
}
