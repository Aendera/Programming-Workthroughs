function scanAndFilter(freightList,item){
    let filteredItems=freightList.filter(element=>{return element!==item;});

    return filteredItems;

}
const filtered = scanAndFilter(
    ['dog', 'ray gun', 'cat', 'zippers', 'ray gun'],
    'ray gun'
  );
  console.log('Filtered Items');
  console.log(filtered);