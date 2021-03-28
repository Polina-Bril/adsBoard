<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <body>
    <div>
        <form action="main-controller" method="get">
            <input type="hidden" name="command" value="find_all_users">
            <input type="submit" name="submit" value="Find all users">
        </form>
    </div>
    <br/>
    <div>
        <h3>Users from id range</h3>
        <form action="main-controller" method="post" name="Users from id range">
            <input type="hidden" name="command" value="find_users_by_ids">
            lower range value: <input type="number" name="lowerValue" value=""> <br/>
            higher range value: <input type="number" name="higherValue" value=""> <br/>
            <input type="submit" name="submit" value="Display">
        </form>
    </div>
    <br/>
    <div>
        <form action="main-controller" method="get">
            <input type="hidden" name="command" value="sort_users">
            <input type="submit" name="submit" value="Sort users by id">
        </form>
    </div>
    </body>
</html>
