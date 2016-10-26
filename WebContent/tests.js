QUnit.test ( " hello test " , function ( assert ) {
assert.ok ( 1 == "1" , " Passed !" );
});
QUnit.test ( " hello test " , function ( assert ) {
assert.ok ( 1 == "1" , " Passed !" );
});
function subtruct(a,b){
    return a-b;
}
QUnit.test ( " hello test " , function ( assert ) {
assert.ok ( 1 == "1" , " Passed !" );
assert.ok ( subtruct(1,1) == 0 , " Passed !" );
});