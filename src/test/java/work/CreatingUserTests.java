package work;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

public class CreatingUserTests extends BaseTest {

    private UserApiService userApiService = new UserApiService();

    @DataSupplier(transpose = true)
    public List<User> getDifferentUsers() {
        return StreamEx.of(
                getCorrectUser(),
                getLongNameUser(),
                getEmptyFirstNameUser(),
                getEmptyLastNameUser(),
                new BIConversion.User().setFirstName("").setLastName(""))
                .toList();
    }

    @Test(description = "", dataProvider = "getDifferentUsers")
    public void testCanCreateCorrectUser(User user) {
        userApiService.addUser(getCorrectUser());
    }
}
