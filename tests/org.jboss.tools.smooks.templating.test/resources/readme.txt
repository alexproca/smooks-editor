xCBL 4.0 distribution
^^^^^^^^^^^^^^^^^^^^^
xCBL 4.0 is provided as a ZIP archive file. This
contains both the XML schemas that constitute the
xCBL 4.0 component library and also sample data
demonstrating valid XML instances of the xCBL 4.0
documents.

Info:
Download size: 1.8Mb
Approx unzipped size: 20Mb
Last updated: March 2003

Notes on the Schemas and Samples:
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
In order for the schemas and samples to function
properly, you will need to ensure that when
extracting the files from the ZIP archive, the
folder structure is maintained.

Schema structure:
^^^^^^^^^^^^^^^^^
The xCBL library, unlike earlier versions of xCBL,
is made up of multiple namespaces. This change was
made for several reasons. Primarily, the
'monolithic' namespace approach adopted with
previous versions of xCBL was becoming unwieldy,
and with the number of components in the library
increasing this issue needed to be addressed.
After weighing up several options, the decision
was made to separate the schemas into a "core"
namespace to hold commonly reused components
(specifically only Types), and a number of
"functional area" namespaces, each dealing with
certain types of business documents.
The functional namespaces each reference only the
"core" library namespace and not each other. This
lack of interdependancy is useful in terms of
versioning and highlights another advantage to
this approach - it is easy to version a functional
area, or indeed release a brand new one, without
affecting currently installed copies of the xCBL
4.0 schema library.

For clarity, these namespaces have also been
organised into a related file structure. With
each namespace having its own directory, the path
to which holding information on it's function and
version. Inside this directory, the schema for
that namespace comprises a "root" schema file and
many schema "module" files. In xCBL we decided
upon a convention whereby each Type had it's own
file, and all of these are referenced from the
"root" schema file by way of include tags.

Note on Import, Include and Tools Support: Due to
the multiple namespace and multiple file structure
for xCBL, we had to decide on how we would make
use of the <include> and <import> elements of XML
Schema ( http://www.w3.org/TR/xmlschema-0/). We
discussed at some length the use of import/include
and how this fitted with our understanding of the
inter-relationships between the concepts of
schemas, files, namespaces, etc.
It was decided that from a schema library point of
view it was fair for us to say that we had one
"schema" per namespace, although on a filesystem
this may consist of many individual files. With
this assumption in place, we came to the
conclusion that we could treat import and include
slightly differently. If there is only one schema
per namespace then this is represented by a "root"
schema which itself includes every file associated
with that namespace. Whenever any definitions from
that namespace are to be referenced from a
different namespace the relevant root schema, and
therefore the whole namespace, must be imported.
The problem with this approach is that the
component files in the namespace, other than the
root schema, are often invalid when opened alone.
So when using xCBL 4.0 with an XML tool, one much
always open or reference the "root" schema for the
namespace involved. (e.g. ordermanagement.xsd).

Samples:
^^^^^^^^
There are 3 sets of samples, two of which consists
of auto-generated samples for each possible
document root in xCBL 4.0. The third set, the ABC
samples, have more realistic sample business data
but only cover a subset of the available
documents.

Auto Generated (Full): These were created from the
schemas following certain simple rules (e.g.
always selecting the first element in a choice
construct, etc.) and are designed to populate as
many fields as possible within a document. These
are useful for testing, are technically schema
valid, and have traceable data, but are obviously
not valid examples of business documents.

Auto Generated (Mandatory Only): Also generated
from the schemas, these samples contain only
mandatory elements and therefore represent the
smallest possible valid instance of the document.
Again validity is used to denote schema validity
but these samples do not contain any meaningful
data.

ABC Scenario: These correspond to the "ABC
Scenario" samples provided for previous versions
of xCBL. See http://www.xcbl.org/ for more info.


Schema Location:
^^^^^^^^^^^^^^^^
The W3C XML Schema specification defines a method
by which an instance can provide hints as to where
a processor may find schemas relevant to
validating the instance. In the case of the set of
samples provided here, we have used a relative URL
in the xsi:schemaLocation attribute, to point to
the relevant schemas. This will work assuming that
you extracted all files in the ZIP archive whilst
maintaining directory structure. If you wish to
move the schemas or the samples relative to one
another you may need to alter this attribute by
hand, or locate the schemas through other means
(e.g. via a custom entity resolver)


