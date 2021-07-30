var categoryApi = Vue.resource('/category{/id}');

Vue.component('category-form', {
    props: ['categories'],
    data: function() {
       return {
       name: '',
       req_name: ''
       }
    },
    template:
    '<div>' +
    '<input type="text" placeholder="Enter name category" v-model="name" />' +
    '<input type="text" placeholder="Enter request id " v-model="req_name" />'+
    '<input type="button" value="Save" @click="save" />' +
    '<input type="text" v-model="name" />'+
 //   '<input type="button" value="find" @click="filter" />' +
    '</div>',
    methods: {
    save: function() {
        var category = {name: this.name, req_name: this.req_name};
        categoryApi.save({},category).then(result =>
        result.json().then(data => {
            this.categories.push(data);
            this.name = '';
            this.req_name='';
        })
       )
   }
 }

})

Vue.component('categories-row', {
    props: ['category','categories'],
    template: '<div>'+
        '<i>({{category.id}})</i> {{category.name}}' +
        '<input type="button" value="Delete" @click="del"/>' +
        '</div>',
    methods: {
        del: function() {
        categoryApi.remove({id: this.category.id}).then(result =>{
            if(result.ok) {
                this.categories.splice(this.categories.indexOf(this.category), 1)
            }
        })
        }
    }

});

Vue.component('categories-list', {
  props:['categories'],
  template: '<div>'+
        '<category-form :categories="categories" />'+
        '<categories-row v-for="category in categories" :key="category.id" :category="category" :categories="categories" />'+
        '</div>',
  created: function() {
    categoryApi.get().then(result =>
    result.json().then(data =>
        data.forEach(category => this.categories.push(category))
    )
    )
  }
})

var app = new Vue({
  el: '#app',
  template: '<categories-list :categories="categories" />',
  data: {
    categories: []
  }
})