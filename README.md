# Reflection exercise
<p>This is reflection exercise for persistance. Only implemented startup creation of tables from specified package.
<br>When application starts, it tries to find classes from specified package. Then, founded classes converts to MySQL
tables.<br>Columns are created by founded class fields. Column types and names are determined by field type and name
using reflection. Constraints are defined by annotations, also scanned with reflection.

</p>
