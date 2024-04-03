import React from 'react'
import MainCrosel from '../../components/HomeCarosel/MainCrosel'
import HomeSectionCarosel from '../../components/HomeSectionCarosel/HomeSectionCarosel'
import ele_products from '../../../Data/ele_products.js'
const HomePage = () => {
  return (
    <div>
        <MainCrosel/>
        <div className='space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10'>
            <HomeSectionCarosel data={ele_products} sectionName={"Tv"}/>
            <HomeSectionCarosel data={ele_products} sectionName={"Mobiles"}/>
            <HomeSectionCarosel data={ele_products} sectionName={"Ipads"}/>
            <HomeSectionCarosel data={ele_products} sectionName={"Laptops"}/>
            <HomeSectionCarosel data={ele_products} sectionName={"Hardware"}/>
            
        </div>

    </div>
  )
}

export default HomePage