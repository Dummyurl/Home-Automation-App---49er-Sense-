User Comments";

// We are now ready to print our comments! Below we will loop through our
// comments and print them one by one.

// The while statement will begin the "looping"

/*NOTE that in PHP 7.0, the mysql_fetch_array has been removed -it was previously deprecated 
in earlier versions of PHP.  You find the cod documentation here:  
http://php.net/manual/en/function.mysql-fetch-array.php */

while($row = mysql_fetch_array($comments, MYSQL_ASSOC))
{

  // As we loop through each comment, the specific comment we're working
  // with right now is stored in the $row variable.

  // for example, to print the commenter's name, we would use:
  // $row['name']
  
  // if we want to print the user's comment, we would use:
  // $row['comment']
  
  // As this is a beginner tutorial, to make our code easier to read
  // we will take the values above (from our array) and put them into
  // individual variables

  $name = $row['name'];
  $email = $row['email'];
  $website = $row['website'];
  $comment = $row['comment'];
  $timestamp = $row['timestamp'];

  $name = htmlspecialchars($row['name'],ENT_QUOTES);
  $email = htmlspecialchars($row['email'],ENT_QUOTES);
  $website = htmlspecialchars($row['website'],ENT_QUOTES);
  $comment = htmlspecialchars($row['comment'],ENT_QUOTES);
  
  // We will now print the comment to the screen
  
  echo "  

      Name: $name

      Email: $email

      Website: $website

      Comment: $comment

      Timestamp: $timestamp
    

  ";
}

// At this point, we've added the user's comment to the database, and we can
// now close our connection to the database:
mysql_close($con);

?>