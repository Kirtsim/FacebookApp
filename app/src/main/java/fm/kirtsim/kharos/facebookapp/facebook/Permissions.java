package fm.kirtsim.kharos.facebookapp.facebook;

/**
 * Created by kharos on 11/10/2017
 */

public class Permissions {

    public static final int MIN_ENCODING = 0;
    public static final int EMAIL = 0;
    public static final int PUBLIC_PROFILE = 1;
    public static final int USER_FRIENDS = 2;
    public static final int MAX_ENCODING = 2;

    private static final String[] sPermissionNames= { "email", "public_profile", "user_friends" };

    private Permissions() {}

    private String[] getPermissions(int[] encodings) {
        String[] permissions = new String[encodings.length];
        int index = 0;
        for (Integer encoding : encodings)
            permissions[index++] = getPermission(encoding);
        return permissions;
    }

    private String getPermission(int encoding) {
        if (encoding >= MIN_ENCODING && encoding <= MAX_ENCODING) {
            return sPermissionNames[encoding];
        }
        return "";
    }
}
