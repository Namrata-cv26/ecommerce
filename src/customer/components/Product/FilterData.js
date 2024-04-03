export const color=[
    "white",
    "black",
    "red",
    "pink",
    "green",
    "yellow",
    "blue",
    "brown"
];

export const filters=[
    {
        id:"color",
        name:"color",
        options: [
            {value:"white",label:"white"},
            {value:"black",label:"black"},
            {value:"blue",label:"blue"},
            {value:"red",label:"red"},
            {value:"pink",label:"pink"},
            {value:"green",label:"green"},
            {value:"yellow",label:"yellow"},
            {value:"brown",label:"brown"},
        ],
    },
    {
        id:"size",
        name:"size",
        options:[
            {value:"S",label:"S"},
            {value:"M",label:"M"},
            {value:"L",label:"L"},
        ],
    },
];


export const singleFilter=[
    {
        id: "price",
        name:"price",
        options:[
            {value:"159-399",label:"$159 to $399"},
            {value:"400-699",label:"$400 to $699"},
            {value:"700-999",label:"$700 to $999"},
            {value:"1000-1500",label:"$1000 to $1500"},
            {value:"1500-2000",label:"$1500 to $200"},
        ],
    },
    {
        id:"discount",
        name:"Discount Range",
        options:[
            {value:"10",label:"10% and above"},
            {value:"20",label:"20% and above"},
            {value:"30",label:"30% and above"},
            {value:"40",label:"40% and above"},
            {value:"50",label:"50% and above"},
        ],
    },
    {
        id:"stock",
        name:"Availability",
        options:[
            {value:"in_stock",label:"In Stock"},
            {value:"out_of_stock",label:"Out of Stock"}
        ]
    }

]

export const sortOptions=[
    {name:"Price: Low to High", query:"price_low",current:false},
    {name:"Price: High to Low", query:"price_high",current:false},
]

export default filters;