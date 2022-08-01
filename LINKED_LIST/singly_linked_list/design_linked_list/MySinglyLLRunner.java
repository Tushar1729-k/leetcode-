package singly_linked_list.design_linked_list;

public class MySinglyLLRunner {
  
  public static void main(String[] args) {
    MySinglyLL obj = new MySinglyLL();
    // obj.addAtHead(1);
    // obj.addAtTail(3);
    // obj.addAtIndex(1, 2);
    // System.out.println(obj.get(1));
    // obj.deleteAtIndex(1);
    // System.out.println(obj.get(1));
    // obj.addAtIndex(0, 10);
    // obj.addAtIndex(0, 20);
    // obj.addAtIndex(1, 30);
    // System.out.println(obj.get(0));

    // String[] actions = {"addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","addAtTail","addAtTail","deleteAtIndex","addAtHead","addAtHead","get","addAtTail","addAtHead","get","addAtTail","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","get","addAtIndex","addAtHead","get","addAtHead","deleteAtIndex","addAtHead","addAtTail","addAtTail","addAtIndex","addAtTail","addAtHead","get","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtHead","addAtTail","addAtHead","addAtHead","addAtTail","addAtTail","get","get","addAtHead","addAtTail","addAtTail","addAtTail","addAtIndex","get","addAtHead","addAtIndex","addAtHead","addAtTail","addAtTail","addAtIndex","deleteAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","addAtTail","addAtHead","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","deleteAtIndex","get","get","addAtHead","get","addAtTail","addAtTail","addAtIndex","addAtIndex","addAtHead","addAtTail","addAtTail","get","addAtIndex","addAtHead","deleteAtIndex","addAtTail","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtTail","addAtTail"};
    // int[][] values =   {{38},       {66},       {61},       {76},       {26},       {37},       {8},        {5},            {4},        {45},       {4},  {85},       {37},       {5},  {93},       {10,23},    {21},       {52},       {15},       {47},       {12}, {6,24},       {64},       {4},  {31},       {6},            {40},       {17},       {15},       {19,2},     {11},       {86},       {17}, {55},       {15},           {14,95},      {22},           {66},       {95},       {8},        {47},       {23},       {39},       {30},{27},  {0},        {99},       {45},       {4},        {9,11},     {6},  {81},       {18,32},      {20},       {13},       {42},       {37,91},    {36},           {10,37},      {96},       {57},       {20},           {89},       {18},           {41,5},     {23},       {75},       {7},  {25,51},      {48},       {46},       {29},       {85},       {82},       {6},        {38},       {14},           {1},  {12},{42},        {42},{83},        {13},       {14,20},    {17,34},      {36},       {58},       {2},        {38},{33,59},     {37},       {15},           {64},       {56}, {0},        {40}, {92},       {63},           {35}, {62},       {32}};
    String[] actions = {"addAtHead","addAtTail","addAtTail","get","get","addAtTail","addAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","get","addAtHead","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtIndex","addAtTail","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","get","deleteAtIndex","addAtTail","addAtTail","addAtHead","addAtTail","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtTail","addAtHead","addAtIndex","addAtHead","addAtHead","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtHead","addAtTail","get","addAtHead","get","addAtTail","get","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","get","addAtHead","addAtIndex","addAtTail","get","addAtIndex","get","addAtIndex","get","addAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","addAtIndex","get","addAtHead","addAtTail","addAtTail","addAtHead","get","addAtTail","addAtHead","addAtTail","get","addAtIndex"};
    int[][] values = {{84},{2},{39},{3},{1},{42},{1,80},{14},{1},{53},{98},{19},{12},{2},{16},{33},{4,17},{6,8},{37},{43},{11},{80},{31},{13,23},{17},{4},{10,0},{21},{73},{22},{24,37},{14},{97},{8},{6},{17},{50},{28},{76},{79},{18},{30},{5},{9},{83},{3},{40},{26},{20,90},{30},{40},{56},{15,23},{51},{21},{26},{83},{30},{12},{8},{4},{20},{45},{10},{56},{18},{33},{2},{70},{57},{31,24},{16,92},{40},{23},{26},{1},{92},{3,78},{42},{18},{39,9},{13},{33,17},{51},{18,95},{18,33},{80},{21},{7},{17,46},{33},{60},{26},{4},{9},{45},{38},{95},{78},{54},{42,86}};
    for (int i = 0; i < actions.length; i++) {
      if (i == 26)
        System.out.print("");
      String action = actions[i];
      int[] value = values[i];
      System.out.println(i+"th action ");
      obj.print();
      switch (action) {
        case "get":
          obj.get(value[0]);
          break;
        case "addAtHead":
          obj.addAtHead(value[0]);
          break;
        case "addAtTail":
          obj.addAtTail(value[0]);
          break;
        case "addAtIndex":
          obj.addAtIndex(value[0], value[1]);
          break;
        case "deleteAtIndex":
          obj.deleteAtIndex(value[0]);
          break;
        }
      }
    }

  //   String[] actions = {"addAtHead","addAtTail","addAtTail","get","get","addAtTail","addAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","get","addAtHead","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtIndex","addAtTail","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","get","deleteAtIndex","addAtTail","addAtTail","addAtHead","addAtTail","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtTail","addAtHead","addAtIndex","addAtHead","addAtHead","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtHead","addAtTail","get","addAtHead","get","addAtTail","get","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","get","addAtHead","addAtIndex","addAtTail","get","addAtIndex","get","addAtIndex","get","addAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","addAtIndex","get","addAtHead","addAtTail","addAtTail","addAtHead","get","addAtTail","addAtHead","addAtTail","get","addAtIndex"};
  //   int[][] values =   {{84},       {2},        {39},       {3},  {1},  {42},       {1,80},     {14},       {1},        {53},       {98},       {19},       {12},       {2},  {16},       {33},       {4,17},       {6,8},      {37},       {43},       {11},           {80},       {31},       {13,23},      {17},       {4},  {10,0},     {21},       {73},       {22},       {24,37},      {14},       {97},       {8},        {6},  {17},           {50},       {28},       {76},       {79},       {18},{30},            {5},        {9},        {83},       {3},            {40},       {26},           {20,90},    {30},           {40},       {56},       {15,23},      {51},       {21},       {26},{83},        {30},{12},        {8},            {4},  {20},       {45},       {10},{56},        {18},{33},        {2},  {70},       {57},       {31,24},  {16,92},{40},{23},{26},{1},{92},{3,78},{42},{18},{39,9},{13},{33,17},{51},{18,95},{18,33},{80},{21},{7},{17,46},{33},{60},{26},{4},{9},{45},{38},{95},{78},{54},{42,86}};
  //   for (int i = 0; i < actions.length; i++) {
  //     String action = actions[i];
  //     int[] value = values[i];
  //     System.out.print(i+"th action ");
  //     obj.print();
  //     switch (action) {
  //       case "get":
  //         obj.get(value[0]);
  //         break;
  //       case "addAtHead":
  //         obj.addAtHead(value[0]);
  //         break;
  //       case "addAtTail":
  //         obj.addAtTail(value[0]);
  //         break;
  //       case "addAtIndex":
  //         obj.addAtIndex(value[0], value[1]);
  //         break;
  //       case "deleteAtIndex":
  //         obj.deleteAtIndex(value[0]);
  //         break;
  //     }
  //   }
  // }

}

// obj.addAtHead(38);
//     obj.addAtTail(66);
//     obj.addAtTail(61);
//     obj.addAtTail(76);
//     obj.addAtTail(26);
//     obj.addAtTail(37);
//     obj.addAtTail(8);
//     obj.deleteAtIndex(5);
//     obj.addAtHead(4);
//     obj.addAtHead(45);
//     System.out.println(obj.get(4));
//     obj.addAtTail(85);
//     obj.addAtHead(37);
//     System.out.println(obj.get(5));
//     obj.addAtTail(93);
//     obj.addAtIndex(10, 23);
//     obj.addAtTail(21);
//     obj.addAtHead(52);
//     obj.addAtHead(15);
//     obj.addAtHead(47);
//     System.out.println(obj.get(12));
//     obj.addAtIndex(6, 24);
//     obj.addAtHead(64);
//     System.out.println(obj.get(4));
//     // obj.print();
//     obj.addAtHead(31);
//     // obj.print();
//     obj.deleteAtIndex(6);
//     // obj.print();
//     obj.addAtHead(40);
//     obj.addAtTail(17);
//     obj.addAtTail(15);
//     // obj.print();
//     obj.addAtIndex(19, 2);
//     // obj.print();
//     obj.addAtTail(11);
//     // obj.print();
//     obj.addAtHead(86);
//     System.out.println(obj.get(17));
//     // obj.print();
//     obj.addAtTail(55);
//     obj.deleteAtIndex(15);
//     obj.addAtIndex(14, 95);
//     obj.deleteAtIndex(22);
//     obj.addAtHead(66);
//     obj.addAtTail(95);
//     obj.addAtHead(8);
//     obj.addAtHead(47);
//     obj.addAtTail(23);
//     obj.addAtTail(39);
//     System.out.println(obj.get(30));
//     System.out.println(obj.get(27));
//     obj.addAtHead(0);
//     obj.addAtTail(99);
//     obj.addAtTail(45);
//     obj.addAtTail(4);
//     obj.addAtIndex(9, 11);
//     System.out.println(obj.get(6));
//     obj.addAtHead(81);
//     obj.addAtIndex(18, 32);
//     // obj.print();
//     obj.addAtHead(20);
//     obj.addAtTail(13);
//     obj.addAtTail(42);
//     obj.addAtIndex(37, 91);
//     obj.deleteAtIndex(36);
//     obj.addAtIndex(10, 37);
//     obj.addAtHead(96);
//     obj.addAtHead(57);
//     obj.deleteAtIndex(20);
//     obj.addAtTail(89);
//     obj.deleteAtIndex(18);
//     obj.addAtIndex(41, 5);
//     obj.addAtTail(23);
//     obj.addAtHead(75);
//     System.out.println(obj.get(7));
//     obj.addAtIndex(25, 51);
//     obj.addAtTail(48);
//     obj.addAtHead(46);
//     obj.addAtHead(29);
//     obj.addAtHead(85);
//     obj.addAtHead(82);
//     obj.addAtHead(6);
//     obj.addAtHead(38);
//     obj.deleteAtIndex(14);
//     System.out.println(obj.get(1));
//     System.out.println(obj.get(12));
//     obj.addAtHead(42);
//     System.out.println(obj.get(42));
//     obj.addAtTail(83);
//     obj.addAtTail(13);
//     obj.addAtIndex(14, 20);
//     obj.addAtIndex(17, 34);
//     obj.addAtHead(36);
//     obj.addAtTail(58);
//     obj.addAtTail(2);
//     System.out.println(obj.get(38));
//     obj.addAtIndex(33, 59);
//     obj.addAtHead(37);
//     obj.print();
//     obj.deleteAtIndex(15);
//     obj.print();
//     obj.addAtTail(64);
//     System.out.println(obj.get(56));
//     obj.print();
//     obj.addAtHead(0);
//     obj.print();
//     System.out.println(obj.get(40));
//     obj.addAtHead(92);
//     // obj.print();
//     obj.deleteAtIndex(63);
//     // obj.print();
//     System.out.println(obj.get(35));
//     obj.addAtTail(62);
//     obj.addAtTail(32);
//     obj.print();